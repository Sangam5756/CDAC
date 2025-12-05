import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { useLocation, useNavigate } from 'react-router-dom';

const UpdateMovie = () => {
  const location = useLocation();
  const [movieData, setMovieData] = useState({
    name: "",
    price: "",
    date: "",
    id: ""
  });
  console.log("Movie Data in Update Movie:", movieData);
  console.log("Location State in Update Movie:", location.state);

  const navigate = useNavigate();


  const handleChange = (e) => {
    const { name, value } = e.target;

    setMovieData({ ...movieData, [name]: value });

  }

  const handleSumbit = async () => {
    console.log("Add Movie Clicked");
    console.log()
    try {
      const response = await axios.put("http://localhost:5000/movies/"+movieData.id, movieData);
      alert("Movie Updated successfully");
      console.log(response.data);
      navigate("/show");
    } catch (error) {
      console.log(error)

    }
  }

  useEffect(()=>{

  setMovieData(location.state);
},[])

  return (
    <div className='flex flex-col'>

      <label htmlFor='name'>
        Name :
        <input type="text" value={movieData?.name} onChange={handleChange} name="name" id="name" placeholder='Enter the Name of Movie' />
      </label>

      <label htmlFor="price">
        Price :
        <input type='number' value={movieData?.price} onChange={handleChange} name='price' id='price' placeholder='Enter the Price of Movie' />
      </label>
      <label htmlFor="date">
        Date :
        <input type="date" name="date" id="date"
         value={movieData?.date?.slice(0,10) || ""} 
         onChange={handleChange} />
      </label>
      <button onClick={handleSumbit}>Add Movie</button>
    </div>
  )
}

export default UpdateMovie