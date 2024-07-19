import './App.css'
import Home from './components/home'
import Footer from './components/footer'
import Nav from './components/nav'
import Login from './components/login'
import Register from './components/register'
import React from 'react';
import { Routes, Route} from "react-router-dom";
import MyProfile from './components/myProfile'
import NewTeam from './components/newTeam'
import TeamCreated from './components/teamCreated'
import TeamDetails from './components/teamDetails'
import TeamFinder from './components/teamFinder'
import NotFound from './components/notFound'

function App() {

  return (
    <>
      <Nav/>
      <Routes>
        <Route path="/">
          <Route index element={<Home/>} />
          <Route path="login" element={<Login/>} />
          <Route path="register" element={<Register/>} />
          <Route path='myProfile' element={<MyProfile/>}/>
          <Route path='newTeam' element={<NewTeam/>}/>
          <Route path='teamCreated' element={<TeamCreated/>}/>
          <Route path='teamDetails' element={<TeamDetails/>}/>
          <Route path='teamFinder' element={<TeamFinder/>}/>
          <Route path="*" element={<NotFound/>} />
        </Route>
      </Routes>
      <Footer/>
    </>
  );
}

export default App;