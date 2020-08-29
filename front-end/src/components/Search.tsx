import React from "react";
import styled from "@emotion/styled";

const Search = styled("section")`
  background-color: #eff1f2;
  border-bottom: 0;
  margin: -2.22222em 0 4.44444em -2.22222em;
  padding: 2.22222em;
  width: calc(100% + 4.44444em);
  form {
    text-decoration: none;
    position: relative;
    input[type="text"] {
      padding-right: 2.75em;
    }
  }
`;

export default function Main() {
  return (
    <Search id="search" className="alt">
      <form method="post" action="#">
        <input type="text" name="query" id="query" placeholder="Search" />
      </form>
    </Search>
  );
}
