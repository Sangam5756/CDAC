import { useEffect, useState } from "react";
import DisplayProduct from "./components/DisplayProduct";
import AddProductForm from "./components/AddProductForm";

const App = () => {
  const [products, setProducts] = useState([
    {
      id: 1,
      name: "laptop",
      price: 1000,
    },
    {
      id: 2,
      name: "mouse",
      price: 200,
    },
    {
      id: 3,
      name: "pendrive",
      price: 300,
    },
  ]);

  const addProduct = (product) => {
    console.log(product);

    const newProduct = {
      ...product,
      id: Number(product.id),
      price: Number(product.price),
    };
    const p = products.filter((p) => p.id === newProduct.id);
    if (p.length !== 0) {
      alert("hey duplicate id enter another");
      return;
    }
    setProducts([...products, newProduct]);
  };

  const editproduct = (product) => {
    setProducts(
      products.map((p) => {
        if (p.id === product.id) {
          return { ...p, ...product };
        }
        return p;
      })
    );
  };

  const getProductById = (id) => {
    console.log(id);
    console.log(products);
    return products.filter((p) => {
      console.log(p);
      return p.id === Number(id);
    });
  };

  const deleteProduct = (id) => {
    console.log(id);

    const arr = products.filter((p) => p.id !== id);
    setProducts(arr);
  };

  useEffect(() => {}, [products]);

  return (
    <div
      style={{
        display: "flex",
        flexDirection: "column",
        gap: 20,
      }}
    >
      <DisplayProduct products={products} deleteProduct={deleteProduct} />
      <AddProductForm
        product={products}
        addProduct={addProduct}
        getProductById={getProductById}
        editproduct={editproduct}
      />
    </div>
  );
};

export default App;
