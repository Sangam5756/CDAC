const mysql2 = require("mysql2");



const dbConnection = mysql2.createConnection({
    host: "localhost",
    user: "root",
    password: "root123",
    database: "productdb"
});
dbConnection.connect((err) => {
    if (err) {
        console.error("Error connecting to the database:", err);
        return;
    }   
    console.log("Connected to the MySQL database.");
});


module.exports = dbConnection;