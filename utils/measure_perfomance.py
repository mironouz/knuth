#!/usr/bin/env python
import importlib.util
import json
import os
import sys
import time

sys.path.insert(1, '/home/felios/workspace/Knuth/src/main/python')


measures = []
for root, dirs, files in os.walk(sys.argv[1]):
    for file in files:
        if file[-3:] == '.py':
            module_name = file.split('.')[0]
            spec = importlib.util.spec_from_file_location(module_name, root + '/' + file)
            module = importlib.util.module_from_spec(spec)
            spec.loader.exec_module(module)
            for name, f in module.__dict__.items():
                if callable(f) and name[-4:] == 'case':
                    start = time.perf_counter()
                    f()
                    measured_time = time.perf_counter() - start
                    measures.append({
                        'module_name': module_name,
                        'benchmark_name': name,
                        'measured_time': measured_time
                    })
with open(sys.argv[2], 'w') as output_file:
    json.dump(measures, output_file, indent=2)
