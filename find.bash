#!/bin/bash

directory="/home/flip/Desktop"
suffix="in"

browsefolders ()
  for i in "$1"/*;
  do
    echo "dir :$directory"
    echo "filename: $i"
    #   echo ${i#*.}
    extension=`echo "$i" | cut -d'.' -f2`
    echo "Erweiterung $extension"
    if     [ -f "$i" ]; then

        if [ $extension == $suffix ]; then
            echo "$i ends with $in"

        else
            echo "$i does NOT end with $in"
        fi
    elif [ -d "$i" ]; then
    browsefolders "$i"
    fi
  done
}
browsefolders  "$directory"
