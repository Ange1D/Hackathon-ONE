import Home from './components/home'
import Footer from './components/footer'
import Nav from './components/nav'
import Login from './components/login'
import Register from './components/register'
import { Routes, Route} from "react-router-dom";
import Profile from './components/myProfile'
import NewTeam from './components/newTeam'
import TeamCreated from './components/teamCreated'
import TeamDetails from './components/teamDetails'
import TeamFinder from './components/teamFinder'
import NotFound from './components/notFound'
import CheckApiConnection from './components/Auth/checkApiConection.jsx'

function App() {
  
  return (
    <>
      <Nav/>
      <Routes>
        <Route path="/">
          <Route index element={<Home/>} />
          <Route path="login" element={<Login/>} />
          <Route path="register" element={<Register/>} />
          <Route path='myProfile' element={<Profile/>}/>
          <Route path='newTeam' element={<NewTeam/>}/>
          <Route path='teamCreated' element={<TeamCreated/>}/>
          <Route path='teamDetails' element={<TeamDetails/>}/>
          <Route path='teamFinder' element={<TeamFinder/>}/>
          <Route path="*" element={<NotFound/>} />
        </Route>
      </Routes>
      <Footer/>
      <CheckApiConnection/>
    </>
  );
}

export default App;