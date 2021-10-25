
import './App.css';
import "slick-carousel/slick/slick.css";
import "slick-carousel/slick/slick-theme.css";
import { BrowserRouter, Route, Switch } from "react-router-dom";
import home from './components/home/Home';

function App() {
  return (
    <BrowserRouter>
    <switch>
      <Route exact path="/" component={home} />
    </switch>    
    </BrowserRouter>
  );
}

export default App;