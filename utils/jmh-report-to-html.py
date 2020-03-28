#!/usr/bin/env python

import sys

html = '<table style="border:1px solid">'
cell = '<td>{}</td>'

with open(sys.argv[1], 'r') as f:
    for line in f:
        html += '<tr>'
        for item in line.split():
            html += cell.format(item)
        html += '</tr>'
    html += '</table>'

with open(sys.argv[2], 'w') as f:
    f.write(html)
