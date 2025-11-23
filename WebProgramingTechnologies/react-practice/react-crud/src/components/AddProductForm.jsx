import { useEffect, useState } from "react";

const AddProductForm = ({ getProductById, addProduct, editproduct }) => {
  const [productData, setProductData] = useState({
    id:0,
    name: "",
    price: 0,
  });

  const [editActive, setEditActive] = useState(false);

  const handleChange = (e) => {
    setProductData({ ...productData, [e.target.name]: e.target.value });
  };

  useEffect(() => {
    if (editActive) {
      let id = prompt("Enter the id of product to edit");

      if (!id) return;

      const p = getProductById(parseInt(id));
      if (p.length === 0) {
        alert("Product not found");
        setEditActive(false);
        return;
      }
      setProductData(p[0]);
    }
    if (!editActive) {
      setProductData({ id, name: "", price });
    }
  }, [editActive]);

  return (
    <div>
      <label htmlFor="id">Enter id</label>
      <input
        value={productData?.id}
        onChange={handleChange}
        type="number"
        name="id"
        id="id"
      />
      <br />

      <label htmlFor="name">Enter name</label>
      <input
        type="text"
        name="name"
        id="name"
        value={productData?.name}
        onChange={handleChange}
      />

      <br />

      <label htmlFor="price">Enter price</label>
      <input
        type="number"
        name="price"
        id="price"
        value={productData?.price}
        onChange={handleChange}
      />

      <br />

      <label htmlFor="check">
        <input
          type="checkbox"
          name="checkbox"
          checked ={editActive}
          id="check"
          onChange={(e) => setEditActive(e.target.checked)}
        />
        edit
      </label>

      <br />

      {editActive ? (
        <button onClick={() => editproduct(productData)}>edit product</button>
      ) : (
        <button
          onClick={() => {
            addProduct(productData);
            setProductData({ id, name: "", price });
          }}
        >
          Add product
        </button>
      )}
    </div>
  );
};

export default AddProductForm;
