const DisplayProduct = ({ products,deleteProduct }) => {
  console.log(products);
  return (
    <div>
      <ul>
        {products.map((p) => {
          return (
            <>
              <li key={p.id}>
                id: &nbsp;
                {p.id}
                &nbsp; name : {p.name}
                &nbsp; &nbsp; price: {p.price}
                  &nbsp;    &nbsp;    &nbsp;<button onClick={()=>deleteProduct(p.id)}>delete</button>
              </li>
              <br />
            </>
          );
        })}
      </ul>
    </div>
  );
};

export default DisplayProduct;
