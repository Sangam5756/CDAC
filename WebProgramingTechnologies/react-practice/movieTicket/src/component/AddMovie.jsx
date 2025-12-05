import axios from 'axios';
import React, { useState } from 'react'
import { useNavigate } from 'react-router-dom';

const AddMovie = () => {

  const navigate = useNavigate();
  const [data, setData] = useState({
    name: "",
    price: "",
    date: ""
  });

  const handleChange = (e) => {
    const { name, value } = e.target;

    setData({ ...data, [name]: value });
  }

  const handleSumbit = async () => {
    console.log("Add Movie Clicked");
    console.log(data);
    try {
      const response = await axios.post("http://localhost:5000/movies", data);
      alert("Movie added successfully");
      console.log(response.data.message + "" + response.data.movieId);
      navigate("/show");
    } catch (error) {
      console.log(error)

    }
  }

  return (
    <div className='flex flex-col'>

      <label htmlFor='name'>
        Name :
        <input type="text" value={data.name} onChange={handleChange} name="name" id="name" placeholder='Enter the Name of Movie' />
      </label>

      <label htmlFor="price">
        Price :
        <input type='number' value={data.price} onChange={handleChange} name='price' id='price' placeholder='Enter the Price of Movie' />
      </label>
      <label htmlFor="date">
        Date :
        <input type="date" name="date" id="date" value={data.date} onChange={handleChange} />
      </label>
      <button onClick={handleSumbit}>Add Movie</button>
    </div>
  )
}

export default AddMovie