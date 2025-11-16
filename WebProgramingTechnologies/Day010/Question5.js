// 5) Create a file mydata.txt, myfile.data read contents of both files parallelly and display number of 
// words in each file .(use asynchronous api).
import {readFile} from 'fs/promises';


async function countWordsInFiles(file) {
    const data = await readFile(file,'utf-8');
    const words = data.split(/\s+/);
    console.log(words.length);
    return words.length;
}

async function main(){

    try{
        const files =[ "data.txt","data2.txt"];
        const promises  = files.map(file => countWordsInFiles(file).then(count => ({file, count})));
        const result = await Promise.all(promises);
        for(var res of result){
            console.log(`File: ${res.file}, Word Count: ${res.count}`); 
        }
    }catch(err){
        console.log(err);
    }

}


main();