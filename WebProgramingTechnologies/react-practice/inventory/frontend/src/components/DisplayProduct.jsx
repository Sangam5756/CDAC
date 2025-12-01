import React from 'react'

const DisplayProduct = (props) => {

    /* "id": 4,
            "name": "T-Shirt (Large)",
            "price": "19.50",
            "quantity": 500,
            "category": "CLOTH", */
    return (
        <div>

            <ul className='px-10 '>
                {props.product.map(p => {
                    return (
                        <li key={p.id} className="bg-slate-400 mt-2">{p.name} {p.price} {p.quantity} {p.category} <button className='bg-green-400 px-2' onClick={()=> {
                            props.setUpdateData(p)
                            props.setisUpdate(true)
                        }}>Update</button> <button onClick={()=> props.handleDelete(p.id)} className='px-2 bg-red-500'>Delete</button></li>
                    )
                })}
            </ul>

        </div>
    )
}

export default DisplayProduct