import React, { useEffect, useState } from 'react';
import { useLocation ,useHistory} from 'react-router-dom';



export default function Navbar() {
    const location = useLocation();
    const history =useHistory();
    const [showLink, setShowLink] = useState(false);

    useEffect(() => {
        setShowLink(sessionStorage.getItem('IsUserLoggedIn'));

    }, [])

    const logoutUser = () => {
        sessionStorage.removeItem('userId');
        // sessionStorage.setItem('IsUserLoggedIn',false);
        sessionStorage.removeItem('IsUserLoggedIn');
        setShowLink(false);
        history.push('/login');
        // const newLocation = { ...location, pathname: '/' };
        // const newLocationString = `${newLocation.pathname}${newLocation.search}${newLocation.hash}`;
        // window.location.href = newLocationString;

    }

    return (
        <div>
            {/* <div >
<span style=" color Shipping on All Orders
"Get Extra <100 OFF on Spent
<span>
<span style=" color : #000; font
of *999 Use Code:"
BEYOUNGIØO
</span>
</div> */}


            <div>

                <nav className="navbar navbar-expand-lg  navbar-light  bg-light bg-gray py-2 shadow-sm fixed-top" style={{ zIndex: 100 }} >

                    <div className="container-fluid">

                        {/* fs-4 fs-1 fs-3 hyane font increase decrease karta yeto */}
                        <a className="navbar-brand fw-bold fs-2 " href="/" style={{ marginLeft: '50px', color: '#c209c1' }} >
                            <i className='fa fa-shopping-bag'></i> &nbsp;
                            shopX  </a>
                        <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                            <span className="navbar-toggler-icon"></span>
                        </button>
                        <div className="collapse navbar-collapse" id="navbarSupportedContent">
                            {/* mx kel tr links lamb jatet */}
                            <ul className="navbar-nav mx-auto mb-2 mb-lg-0">
                                <li className="nav-item">
                                    <a className="nav-link active text-primary" aria-current="page" href="/">
                                        Home
                                    </a>
                                </li>


                                <li className="nav-item">
                                    <a className="nav-link  text-primary" href="/Products">
                                        Products
                                    </a>
                                </li>
                                <li className="nav-item">
                                    <a className="nav-link  text-primary" href="/aboutus">
                                        About
                                    </a>
                                </li>
                                <li className="nav-item">
                                    <a className="nav-link  text-primary" href="/contactUs">
                                        Contact
                                    </a>

                                </li>
                                <div class="container-fluid">
                                    <form class="d-flex" role="search">
                                        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search" />
                                        <button class="btn btn-outline-success" type="submit">Search</button>
                                    </form>
                                </div>


                            </ul>

                            <div className='buttons'>
                                {/* button over effect */}



                                {showLink ? (
                                        <div class="dropdown" >
                                            <button class="btn btn-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
                                                <i className='fa fa-user me-1'></i>
                                                Profile
                                            </button>
                                            <ul class="dropdown-menu">
                                                <li><a class="dropdown-item" href="profile">My Profile</a></li>
                                                <li><a class="dropdown-item" href="#">Manage Account</a></li>
                                                <li><a class="dropdown-item" href="#">Change Password</a></li>
                                                <li><a class="dropdown-item" href="#">My orders</a></li>
                                                <li><a class="dropdown-item" href="#">My orders</a></li>
                                                <li><a class="dropdown-item" href="/logout" onClick={() => logoutUser()}>Logout</a></li>

                                            </ul>
                                        </div>)
                                        

                                    
                                    : (
                                        <a href='/login' className='btn btn-outline-dark'>
                                            <i className='fa fa-sign-in me-1'></i>
                                            Login
                                        </a>
                                    )}&nbsp;&nbsp;

                                {showLink ? (
                                    <a href='/logout' className='btn btn-outline-dark' onClick={() => logoutUser()}>
                                        <i className='fa fa-sign-out me-1'></i>
                                        Logout
                                    </a>) : (
                                    <a href='/register' className='btn btn-outline-dark ms-2'>   {/*  ms-2 ne button madhe space yeto */}
                                        <i className='fa fa-user-plus me-1'></i>
                                        ragister
                                    </a>

                                )}

                                <a href='' className='btn btn-outline-dark ms-2 '>
                                    <i className='fa fa-shopping-cart me-1'></i>
                                    Cart(0)
                                </a>
                            </div>
                        </div>
                    </div>
                </nav>

            </div>
        </div>
    )
}
