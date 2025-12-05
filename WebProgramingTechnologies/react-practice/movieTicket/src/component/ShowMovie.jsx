import axios from 'axios';
import React, { useEffect, useState } from 'react'

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

    return (
        <div>
            <h1>ShowMovie</h1>
            {
                movie.map((item) => (
                    <div key={item?.id}>
                        <h2>{item?.name}</h2>
                        <p>{item?.price}</p>

                    </div>
                ))
            }
        </div>
    )
}

export default ShowMovie