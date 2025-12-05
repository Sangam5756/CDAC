const express =require("express")
const cors = require("cors")
const productRouter = require("./routes")
const app = express();
require("./dbconfig/db");

app.use(express.json());
app.use(cors({
    origin: '*'
}))


app.use("/product",productRouter)



app.listen(3000, () => {
    console.log("Server is running on port 3000");
});