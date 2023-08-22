import React from 'react'

export default function Navbar() {
    return (
        <div>
            <nav className="navbar navbar-expand-lg  navbar-light bg-light bg-white py-3 shadow-sm ">
                <div className="container">

                    {/* fs-4 fs-1 fs-3 hyane font increase decrease karta yeto */}
                    <a className="navbar-brand fw-bold fs-4" href="#">ShOpX</a>
                    <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                        <span className="navbar-toggler-icon"></span>
                    </button>
                    <div className="collapse navbar-collapse" id="navbarSupportedContent">
                        {/* mx kel tr links lamb jatet */}
                        <ul className="navbar-nav mx-auto mb-2 mb-lg-0">
                            <li className="nav-item">
                                <a className="nav-link active" aria-current="page" href="#">
                                    Home
                                </a>
                            </li>
                            <li className="nav-item">
                                <a className="nav-link" href="#">
                                    Products
                                </a>
                            </li>
                            <li className="nav-item">
                                <a className="nav-link" href="#">
                                    About
                                </a>
                            </li>
                            <li className="nav-item">
                                <a className="nav-link" href="#">
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
                            <a href='' className='btn btn-outline-dark'>
                                <i className='fa fa-sign-in me-1'></i>
                                Login
                            </a>
                            <a href='' className='btn btn-outline-dark ms-2'>   {/*  ms-2 ne button madhe space yeto */}
                                <i className='fa fa-user-plus me-1'></i>
                                Ragister
                            </a>
                            <a href='' className='btn btn-outline-dark ms-2 '>
                                <i className='fa fa-shopping-cart me-1'></i>
                                Cart(0)
                            </a>
                        </div>
                    </div>
                </div>
            </nav>

        </div>
    )
}
