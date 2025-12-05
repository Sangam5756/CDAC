const express = require('express');
const movieRouter = express.Router();
const movieController = require('../controller/movie.controller')
const db = require('../dbconfig/dbconfig');

movieRouter.get("/", movieController.getMovies);
movieRouter.post("/", movieController.createMovie);
movieRouter.delete("/:id", movieController.deleteMovie);
movieRouter.put("/:id", movieController.updateMovie);

module.exports = movieRouter;
