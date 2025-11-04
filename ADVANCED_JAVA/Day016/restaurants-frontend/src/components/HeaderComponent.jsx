import React from 'react';
import { NavLink } from 'react-router-dom';

const HeaderComponent = () => {
  return (
    <>
      <header>
        <nav className='navbar navbar-dark bg-dark navbar-expand-lg'>
          <a className='navbar-brand' href='https://www.developers.com'>
            Restaurants Management
          </a>
          <div className='collapse navbar-collapse' id='myNavBar'>
            <ul className='navbar-nav'>
              <li className='nav-item'>
                <NavLink className='nav-link' to='/restaurants'>
                  restaurants
                </NavLink>
              </li>
            </ul>
          </div>
        </nav>
      </header>
    </>
  );
};

export default HeaderComponent;
