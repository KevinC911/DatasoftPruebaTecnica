import { Navigate, Outlet } from "react-router"

function PrivateRoute() {
    const isAuthenticated = !!localStorage.getItem("token")
    
    return isAuthenticated ? <Outlet /> : <Navigate to="/" />
}

export default PrivateRoute;