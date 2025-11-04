import { useEffect, useState } from 'react';
import {
  deleteRestaurantById,
  getAllRestaurants,
} from '../services/RestaurantService';
import { useNavigate } from 'react-router-dom';
const ListRestaurants = () => {
  const [restaurants, setRestaurants] = useState([]);
  const navigate = useNavigate();
  //useEffect hook
  useEffect(() => {
    getRestaurants();
  }, []);

  //function  to get all restaurant details from the backend
  function getRestaurants() {
    getAllRestaurants()
      .then((response) => {
        setRestaurants(response.data);
      })
      .catch((error) => {
        console.error(error);
      });
  }
  //function to navigate user to add new restaurant component
  function addNewRestaurant() {
    navigate('/add-restaurant');
  }
  //function for update btn click handler
  function handleUpdateRestaurant(restaurantId) {
    console.log('in update ' + restaurantId);
    //navigate to SaveOrUpdateUpdateRestaurant
    navigate(`/edit-restaurant/${restaurantId}`);
  }
  function handleDeleteRestaurant(restaurantId) {
    //REST API call
    deleteRestaurantById(restaurantId)
      .then((response) => {
        console.log(response.data);
        // navigate('/restaurants');
        getRestaurants();
      })
      .catch((err) => console.error(err));
  }
  return (
    <div className='container'>
      <button className='btn btn-primary mb-2 mt-2' onClick={addNewRestaurant}>
        Add New Restaurant
      </button>
      {restaurants && (
        <div>
          <h3>Restaurant List</h3>
          <table className='table table-striped table-bordered'>
            <thead>
              <tr>
                <td>Restaurant ID</td>
                <td>Name</td>
                <td>Description</td>
                <td>Last Updated</td>
                <td>Actions</td>
                <td>Actions</td>
              </tr>
            </thead>
            <tbody>
              {restaurants.map((restaurant) => (
                <tr key={restaurant.id}>
                  <td>{restaurant.id}</td>
                  <td>{restaurant.restaurantName}</td>
                  <td>{restaurant.description}</td>
                  <td>{restaurant.updatedOn}</td>
                  <td>
                    <button
                      className='btn btn-info'
                      onClick={() => handleUpdateRestaurant(restaurant.id)}
                    >
                      Update
                    </button>
                  </td>
                  <td>
                    <button
                      className='btn btn-danger'
                      onClick={() => handleDeleteRestaurant(restaurant.id)}
                    >
                      Delete
                    </button>
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      )}
    </div>
  );
};
export default ListRestaurants;
