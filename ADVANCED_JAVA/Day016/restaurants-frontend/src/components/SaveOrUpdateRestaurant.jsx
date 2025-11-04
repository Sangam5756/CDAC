import React, { useState, useEffect } from 'react';
import {
  updateRestaurant,
  addNewRestaurant,
  getRestaurantById,
} from '../services/RestaurantService';
import { useNavigate, useParams } from 'react-router-dom';

const AddRestaurantComponent = () => {
  const [restaurantName, setRestaurantName] = useState('');
  const [description, setDescription] = useState('');
  const navigate = useNavigate();
  const { restaurantId } = useParams();
  const title = 'Add';
  //add new state object to hold validation errors (client side)
  const [errors, setErrors] = useState({
    restaurantName: '',
    description: '',
  });
  useEffect(() => {
    if (restaurantId) {
      //make REST API call to get restaurant details
      getRestaurantById(restaurantId)
        .then((response) => {
          setRestaurantName(response.data.restaurantName);
          setDescription(response.data.description);
        })
        .catch((err) => {
          console.error(err);
        });
    }
  }, [restaurantId]);
  //useEffect hook added for logging errors !
  useEffect(() => {
    console.log('Errors:', errors);
  }, [errors]);
  //add validation rules
  function validateForm() {
    //copy errors object in errorCopy
    const errorsCopy = { ...errors };
    let valid = true;
    if (restaurantName.trim()) {
      errorsCopy.restaurantName = '';
    } else {
      valid = false;
      errorsCopy.restaurantName = 'Restaurant Name is required !';
    }
    if (description.trim()) {
      errorsCopy.description = '';
    } else {
      valid = false;
      errorsCopy.description = 'Description is required !';
    }
    setErrors(errorsCopy);
    return valid;
  }
  function createNewRestaurant() {
    //create restaurant object
    const restaurant = { restaurantName, description };
    console.log(restaurant);
    addNewRestaurant(restaurant)
      .then((response) => {
        console.log(response.data);
        navigate('/categories');
      })
      .catch((err) => {
        console.error(err);
      });
  }
  function updateRestaurantDetails() {
    //create restaurant object
    const restaurant = { restaurantName, description };
    console.log('update ' + restaurant);
    updateRestaurant(restaurantId, restaurant)
      .then((response) => {
        console.log(response.data);
        navigate('/categories');
      })
      .catch((err) => {
        console.error(err);
      });
  }
  //JS function to save restaurant details
  /*
  1. create restaurant object from the state
  2. invoke RestaurantService's addRestaurant n pass this 
  3. navigate to list categories
  */
  function saveOrUpdateRestaurantDetails(e) {
    e.preventDefault();
    //check for validation errors
    if (validateForm()) {
      if (restaurantId) {
        //update restaurant
        updateRestaurantDetails();
      } else {
        createNewRestaurant();
      }
    } else {
      console.error(`validation errors ${errors}`);
    }
  }
  return (
    <div className='container'>
      <div className='row justify-content-center'>
        <div className='col-md-6'>
          <div className='card'>
            <h3 className='card-header'>
              {restaurantId ? 'Update' : 'Add'} Restaurant Details
            </h3>
            <div className='card-body'>
              <form>
                <div className='form-row mb-3'>
                  <label className='col-form-label'>Name</label>
                  <input
                    type='text'
                    className={`form-control ${
                      errors.restaurantName ? 'is-invalid' : ''
                    }`}
                    placeholder='Enter Restaurant Name'
                    name='restaurantName'
                    value={restaurantName}
                    onChange={(e) => setRestaurantName(e.target.value)}
                  />
                  {errors.restaurantName && (
                    <div className='invalid-feedback'>
                      {errors.restaurantName}
                    </div>
                  )}
                </div>
                <div className='mb-3'>
                  <label className='form-label'>Description</label>
                  <input
                    type='text'
                    className={`form-control ${
                      errors.description ? 'is-invalid' : ''
                    }`}
                    placeholder='Enter Restaurant Desc'
                    name='description'
                    value={description}
                    onChange={(e) => setDescription(e.target.value)}
                  />
                  {errors.description && (
                    <div className='invalid-feedback'>{errors.description}</div>
                  )}
                </div>
                <div className='d-grid gap-2'>
                  <button
                    className='btn btn-success'
                    onClick={saveOrUpdateRestaurantDetails}
                  >
                    Submit
                  </button>
                </div>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default AddRestaurantComponent;
