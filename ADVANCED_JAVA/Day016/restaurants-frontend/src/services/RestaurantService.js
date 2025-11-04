import axios from 'axios';
const BASE_URL = 'http://localhost:8080/restaurants';
export const getAllRestaurants = () => {
  return axios.get(BASE_URL);
};

export const addNewRestaurant = (restaurant) => {
  return axios.post(BASE_URL, restaurant);
};
export const getRestaurantById = (id) => {
  return axios.get(BASE_URL + `/${id}`);
};
export const updateRestaurant = (id, restaurant) => {
  return axios.put(BASE_URL + `/${id}`, restaurant);
};
export const deleteRestaurantById = (id) => {
  return axios.delete(BASE_URL + `/${id}`);
};
