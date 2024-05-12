<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<footer class="bg-dark text-white py-4">
    <div class="container">
        <div class="row">
            <div class="col-lg-6">
                <h5>Contact Us</h5>
                <p>Email: <%=application.getInitParameter("email")%></p>
                <p>Phone: <%=application.getInitParameter("phone")%></p>
                <p>Author:<%=config.getInitParameter("author")%></p>
            </div>
            <div class="col-lg-6">
                <h5>Follow Us</h5>
                <ul class="list-inline">
                    <li class="list-inline-item"><a href="#">Facebook</a></li>
                    <li class="list-inline-item"><a href="#">Twitter</a></li>
                    <li class="list-inline-item"><a href="#">Instagram</a></li>
                </ul>
            </div>
        </div>
        <div class="row mt-3">
            <div class="col">
                <p class="text-center">© 2024 My Website. All Rights Reserved.</p>
            </div>
        </div>
    </div>
</footer>

<!-- Bootstrap JS and dependencies -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
