
const db = require('../dbconfig/dbconfig');
class MovieController {



    createMovie(req, res) {
        const { name, price, date } = req.body;

        // got the movie
        // then add to the db
        const insertQuery = `insert into movie(name,price,date) values(?,?,?)`;
        db.query(insertQuery, [name, price, date], (err, result) => {
            if (err) {
                console.error('Error inserting movie:', err);
                return res.status(500).json({ message: "Error inserting movie" });
            } else {
                return res.status(201).json({ message: "Movie inserted successfully", movieId: result.insertId });
            }
        })
    }

    getMovies(req, res) {
        const selectQuery = `select * from movie`;
        db.query(selectQuery, (err, results) => {
            if (err) {
                res.json({ message: "Error fetching movies" });
            } else {
                res.json(results);
            }
        })
    }

    updateMovie(req, res) {
        let { id, name, price, date } = req.body;
        const updateQuery = 'update movie set name=?,price=?,date=? where id=?';
            date = date.slice(0,10);
            console.log(date);
        db.query(updateQuery, [name, price,date, id], (err, result) => {
            if (err) {
                console.log(err)
                res.json({ message: "Error updating movie" });
            } else {
                console.log(result)
                res.json({ message: "Movie updated successfully" });
            }
        })

    }

    deleteMovie(req, res) {
        const { id } = req.params;
        const deleteQuery = 'delete from movie where id=?';
        db.query(deleteQuery, [id], (err, result) => {
            if (err) {
                res.json({ message: "Error deleting movie" });
            } else {
                res.json({ message: "Movie deleted successfully" });
            }
        })
    }


}


module.exports = new MovieController();