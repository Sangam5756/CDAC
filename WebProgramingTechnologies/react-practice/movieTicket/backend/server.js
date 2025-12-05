const express = require('express');

const cors = require('cors');
const movieRouter = require("./routes/movie.route")

const app = express();

const PORT = 5000;

app.use(cors({
    origin: "*"
}));

app.use(express.json());

app.use("/movies", movieRouter);

app.get("/", (req, res) => {
    res.send("Movie Ticket Booking Backend is Running");
});



app.listen(PORT, () => {
    console.log(`Server is running on http://localhost:${PORT}`);
});