// Create a simple text file. Now use node file handling to read each line from text file, prefix line with 
// a number and display.
import { readFile } from 'fs/promises';

async function run(file) {
  const txt = await readFile(file, 'utf8');
  const lines = txt.split('/\s+/');
  const numbered = lines.map((l, idx) => `${idx+1}. ${l}`);
  console.log(numbered.join('\n'));
}

run('data.txt').catch(console.error);