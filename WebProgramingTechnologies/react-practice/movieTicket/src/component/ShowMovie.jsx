import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { Link } from 'react-router-dom';

const ShowMovie = () => {
    const [movie, setMovie] = useState([]);


    const getMovie = async () => {
        try {
            const response = await axios.get("http://localhost:5000/movies");
            setMovie(response.data);
        } catch (error) {
            console.log("Error while fetching movie data:", error);

        }
    }
    useEffect(() => {

        getMovie();

    }, [])

    const handleDelete = async (id) => {

        try {
            const response = await axios.delete(`http://localhost:5000/movies/${id}`);
            getMovie();
            alert("Movie deleted successfully");
        } catch (error) {
            console.log("Error while deleting movie:", error);
        }

    }

    return (
        <div className="px-2 py-2">
            <h1 className="font-bold text-lg mb-2">ShowMovie</h1>
            <Link to="/add-movie" className='bg-green-500 px-2 py-1 rounded-md'>Add new Movie</Link>
            <div className="px-2 py-4 bg-red-400 rounded-md">
                <ul className="space-y-2">
                    {movie?.map((item) => (
                        <li
                            key={item.id}
                            className="flex justify-evenly bg-white text-black px-3 py-2 rounded-md shadow"
                        >
                            <span>{item.name}</span>
                            <span>₹{item.price}</span>
                            <span>{item?.date?.slice(0,10)}</span>
                            <button onClick={() => handleDelete(item.id)}>Delete the movie</button>
                            <Link to={`/update`} state={item}>Update the movie</Link>
                        </li>
                    ))}
                </ul>
            </div>
        </div>

    )
}

export default ShowMovie