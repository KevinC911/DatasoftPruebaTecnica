import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import { createBrowserRouter, RouterProvider } from 'react-router'
import './index.css'
import App from './App.tsx'
import PrivateRoute from './components/PrivateRoute.tsx'
import Library from './pages/Library.tsx'
import BookDetails from './pages/BookDetails.tsx'
const router = createBrowserRouter([
  {
    path: '/',
    element: <App />,
  },
  {
    path: '/library',
    element: <PrivateRoute />,
    children: [
      {
        path: '/library/books',
        element: <Library />,
      },
      {
        path: '/library/books/:id',
        element: <BookDetails />,
      },
    ],
  },
])

createRoot(document.getElementById('root')!).render(
  <StrictMode>
    <RouterProvider router={router} />
  </StrictMode>,
)
