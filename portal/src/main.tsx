import React from 'react'
import ReactDOM from 'react-dom/client'
import LoginForm from './component/LoginForm/LogintForm'
import './index.css'

ReactDOM.createRoot(document.getElementById('root') as HTMLElement).render(
  <React.StrictMode>
    <div className='mainPageContainer'>
      <LoginForm/>
    </div>
  </React.StrictMode>,
)
