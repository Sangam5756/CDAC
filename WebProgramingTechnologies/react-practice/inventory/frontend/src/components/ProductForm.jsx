import React, { useState } from 'react'

const ProductForm = (props) => {

    const [formdata, setFormdata] = useState({
        name: "",
        price: 0,
        quantity: 0,
        category: ""
    });
    /* "id": 4,
            "name": "T-Shirt (Large)",
            "price": "19.50",
            "quantity": 500,
            "category": "CLOTH", */
    const handleChange = (e) => {
                const {name,value} = e.target;

                setFormdata({...formdata,[name]:value})
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

            <button onClick={() => props.handleProductSubmit(formdata)} className='bg-red-300'>submit</button>
            
        </div>
    )
}

export default ProductForm