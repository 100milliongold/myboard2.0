import React from "react";
import styled from "@emotion/styled";
import pic01 from "../assets/images/288X174.png";

const SideMiniPostLayout = styled("section")`
  border-bottom: solid 2px rgba(210, 215, 217, 0.75);
  margin: 0 0 3.5em 0;
  padding: 0 0 3.5em 0;
`;
const MajorSection = styled("header")`
  h2 {
    font-size: 1.38889em;
    border-bottom: solid 3px #f56a6a;
    display: inline-block;
    margin: 0 0 2em 0;
    padding: 0 0.75em 0.5em 0;
  }
`;
const MiniPosts = styled("div")`
  article {
    border-top: solid 1px rgba(210, 215, 217, 0.75);
    margin-top: 2em;
    padding-top: 2em;
    &: first-child {
      border-top: 0;
      margin-top: 0;
      padding-top: 0;
    }
    .image {
      display: block;
      margin: 0 0 1.5em 0;
      img {
        display: block;
        width: 100%;
      }
    }
  }
`;

export default function SideMiniPost() {
  return (
    <SideMiniPostLayout>
      <MajorSection className="major">
        <h2>Ante interdum</h2>
      </MajorSection>
      <div className="mini-posts">
        <article>
          <a href="#" className="image">
            <img src={pic01} alt="" />
          </a>
          <p>
            Aenean ornare velit lacus, ac varius enim lorem ullamcorper dolore
            aliquam.
          </p>
        </article>
        <article>
          <a href="#" className="image">
            <img src={pic01} alt="" />
          </a>
          <p>
            Aenean ornare velit lacus, ac varius enim lorem ullamcorper dolore
            aliquam.
          </p>
        </article>
        <article>
          <a href="#" className="image">
            <img src={pic01} alt="" />
          </a>
          <p>
            Aenean ornare velit lacus, ac varius enim lorem ullamcorper dolore
            aliquam.
          </p>
        </article>
      </div>
      <ul className="actions">
        <li>
          <a href="#" className="button">
            More
          </a>
        </li>
      </ul>
    </SideMiniPostLayout>
  );
}
