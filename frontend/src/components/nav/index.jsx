import "./nav.css"
import { Link } from "react-router-dom";

const Nav = () => {
    return(
        <nav className="Nav">
            <button className="menu__icon">
                <span></span>
                <span></span>
            </button>
            <a>
                <img src="./images/leeroy-icon.png" alt="leeroy-icon" />
                <h2>Leeroy.GG</h2>
            </a>
            <ul>
                <li><Link to='/'>Home</Link></li>
                <li><Link to='/profile'>Your profile</Link></li>
                <li><Link to='/teamCreated'>Your teams</Link></li>
                <li><Link to='/teamFinder'>Teams finder</Link></li>
                <li><Link to='/login'>Login</Link></li>
                <li><Link to='/register'>Sign up</Link></li>
            </ul>
        </nav>
    )
}

export default Nav;