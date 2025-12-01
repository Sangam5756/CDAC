import React, { useEffect } from 'react'
import DisplayProduct from './components/DisplayProduct'
import axios from 'axios'
import ProductForm from './components/ProductForm'
import UpdateProduct from './components/UpdataProduct'
const App = () => {


  const [product, setProduct] = React.useState([])

  const [isUpdateMode, setIsUpdateMode] = React.useState(false);
  const getProducts = async () => {

    try {
      const response = await axios.get("http://localhost:3000/product");
      setProduct(response.data.data)
    } catch (err) {
      console.error(err)
    }
  }


  useEffect(() => {
    getProducts()

  }, [])

    const handleProductSubmit = async(newProduct) => {


      try {
        const response =await axios.post("http://localhost:3000/product", newProduct);
        console.log(response.data);
        getProducts(); 
      } catch (err) {
        console.error(err);
      }
    
    }

const handleDelete = async (id) => {
  try { 
    const  response = await axios.delete("http://localhost:3000/product/"+id);
    console.log(response.data);
    getProducts(); 
  }
  catch (err) {
    console.error(err);
  }
}
const handleProductUpdata = (data ) =>{
    console.log(data)
}

  return (
    <div className="">

      <DisplayProduct setisUpdate={setIsUpdateMode} setUpdateData={handleProductUpdata} product={product} handleDelete={handleDelete} />
      <UpdateProduct setUpdateData={handleProductUpdata} isUpdateMode ={setIsUpdateMode} />
      <br />
      <ProductForm  handleProductSubmit={handleProductSubmit} />
    </div>
  )
}

export default App