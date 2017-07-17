#!/bin/bash
if [ $# -lt 1 ]; then
    echo "error.. need args, such as ./do.sh FileStorage.java"
    exit 1
fi
echo "commond is $0"
cd My_Storage/src
javac -encoding gbk $1.java
afterCompiler=$1.class
if [ -f "$afterCompiler" ]; then
  cp $1.class ../bin/$1.class
  rm $1.class  
  echo "suc to generate the .class file"
fi