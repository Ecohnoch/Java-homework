#!/bin/bash
if [ $# -lt 1 ]; then
    echo "error.. need args, such as ./do.sh FileStorage.java"
    exit 1
fi
echo "commond is $0"
cd My_Storage/bin
java $@