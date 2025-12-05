import React from 'react'
import { Route, Routes } from "react-router-dom"
import AddMovie from './component/AddMovie'
import ShowMovie from './component/ShowMovie'
import UpdateMovie from './component/UpdateMovie'

const App = () => {
  return (
    <div>
      <Routes>

        <Route path="/add-movie" element={<AddMovie />} />
        <Route path="/show" element={<ShowMovie />} />
        <Route path="/update" element={<UpdateMovie />} />

      </Routes>

    </div>
  )
}

export default App