// 6) Write a program to run node server at port 5000. Display Welcome to nodejs msg on the screen 
// once receives the request. 
import http from 'http';




const server = http.createServer((req, res) => {    
    
    res.end("<p>Welcome to nodejs</p>");
    
});

const PORT = 5000;
server.listen(PORT, () => {
    console.log(`Server running at http://localhost:${PORT}/`);
});