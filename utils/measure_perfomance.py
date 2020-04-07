#!/usr/bin/env python
import os
import sys
import importlib.util
from timeit import timeit

sys.path.insert(1, '/home/felios/workspace/Knuth/src/main/python')

for root, dirs, files in os.walk(sys.argv[1]):
    for file in files:
        if file[-3:] == '.py':
            module_name = file.split('.')[0]
            spec = importlib.util.spec_from_file_location(module_name, root + '/' + file)
            module = importlib.util.module_from_spec(spec)
            spec.loader.exec_module(module)
            for name, f in module.__dict__.items():
                if callable(f) and name[-4:] == 'case':
                    # measure start
                    f()
                    # measure end
                    # calculate end - start
