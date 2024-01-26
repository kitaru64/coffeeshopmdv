 <nav class="navbar navbar-expand-lg bg-body-tertiary">
                <div class="container-fluid">
                    <a class="navbar-brand" href="/"><b>Coffee Shop</b></a>
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                            <li class="nav-item">
                                <a class="nav-link active" aria-current="page" href="/">Home</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link active" aria-current="page" href="/category">Category</a>
                            </li>

                            <li class="nav-item">
                                <a class="nav-link" href="/aboutus">About Us</a>
                            </li>
                            <form class="d-flex" role="search" method="get" action="/search">
                                <input class="form-control me-2" type="search" name="search" placeholder="Items search..." aria-label="Search">
                                <button class="btn btn-outline-success" type="submit">Go!</button>
                            </form>
                        </ul>


                            <form method="get" action="/cart">
                                <button class="btn btn-primary" type="submit"><i class="bi bi-cart"></i>
                                    Cart </button>
                            </form>
                        </div>
                    </div>
                </div>
 </nav>
