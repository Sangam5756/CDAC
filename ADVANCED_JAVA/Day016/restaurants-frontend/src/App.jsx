import './App.css';
import SaveOrUpdateRestaurantComponent from './components/SaveOrUpdateRestaurant';
import FooterComponent from './components/FooterComponent';
import HeaderComponent from './components/HeaderComponent';
import ListRestaurants from './components/ListRestaurants';
//import ListProducts from './components/ListProducts';
//import SaveOrUpdateProductComponent from './components/SaveOrUpdateProductComponent';
//import ListEmployees from './components/ListEmployees';
import { BrowserRouter, Routes, Route } from 'react-router-dom';

function App() {
  return (
    <div>
      <BrowserRouter>
        <HeaderComponent />
        <Routes>
          {/* http://localhost:3000 */}
          <Route path='/' element={<ListRestaurants />} />
          {/* http://localhost:3000/restaurants */}
          <Route path='/restaurants' element={<ListRestaurants />} />
          {/* http://localhost:3000/add-restaurant */}
          <Route
            path='/add-restaurant'
            element={<SaveOrUpdateRestaurantComponent />}
          />
          {/* http://localhost:3000/edit-restaurant/restaurantId */}
          <Route
            path='/edit-restaurant/:restaurantId'
            element={<SaveOrUpdateRestaurantComponent />}
          />
        </Routes>
        {/* <FooterComponent /> */}
      </BrowserRouter>
    </div>
  );
}

export default App;
