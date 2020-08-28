// styles
import * as React from "react";
import Index from "./containers/Index";
import { HashRouter as Router, Switch, Route, Link } from "react-router-dom";
import "./App.scss";

export const App = () => {
  return (
    <Router>
      <Route path="/" component={Index} />
    </Router>
  );
};

export default App;
