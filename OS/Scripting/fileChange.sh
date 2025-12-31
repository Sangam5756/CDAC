read  file

if diff "$file" "$file.bak" > /dev/null 
then echo "FIle is not modified"
else echo "file is modified"
fi

