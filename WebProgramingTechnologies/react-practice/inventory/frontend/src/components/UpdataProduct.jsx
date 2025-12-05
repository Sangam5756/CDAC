import React, { useState } from 'react'

const UpdateProduct = () => {

    const [formdata, setFormdata] = useState({
        name: "",
        price: 0,
        quantity: 0,
        category: ""
    });



    const handleChange = (e) => {
        const { name, value } = e.target;

        setFormdata({ ...formdata, [name]: value })
    }
    return (
        <div className='px-20 flex flex-col gap-2'>

            <label htmlFor="name"> Name</label>
            <input type="text" id='name' onChange={handleChange} value={formdata.name} name='name' placeholder='enter the product name' />

            <label htmlFor="price"> Price</label>
            <input type="number" id='price' onChange={handleChange} value={formdata.price} name='price' placeholder='enter the product Price' />

            <label htmlFor="quantity"> Quantity</label>
            <input type="number" id='quantity' onChange={handleChange} value={formdata.quantity} name='quantity' placeholder='enter the product quantity' />

            <label htmlFor="category"> Category</label>
            <input type="text" id='category' onChange={handleChange} value={formdata.category} name='category' placeholder='enter the product category' />

            <button onClick={() => props.handleProductUpdata(formdata)} className='bg-red-300'>Update data</button>

        </div>
    )
}

export default UpdateProduct