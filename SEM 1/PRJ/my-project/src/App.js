import { BrowserRouter, Route, Routes } from "react-router-dom";
import "./App.css";
import Homepage from "./components/Homepage";
import Viewpage from "./components/viewpage";
function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Homepage />}></Route>
        <Route path="/viewpage/:id" element={<Viewpage />}></Route>
      </Routes>
    </BrowserRouter>
  );
}

export default App;
