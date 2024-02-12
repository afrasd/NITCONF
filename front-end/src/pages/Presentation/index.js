import React from "react";
import Container from "@mui/material/Container";
import Grid from "@mui/material/Grid";
import Card from "@mui/material/Card";
import MKBox from "components/MKBox";
import MKTypography from "components/MKTypography";
import Information from "pages/Presentation/sections/Information";
import Testimonials from "pages/Presentation/sections/Testimonials";
import bgImage from "assets/images/bg-presentation.jpg";

// const CLIENT_ID = "";

// function loginWithGithub() {
//   window.location.assign("https://github.com/login/oauth/authorize?client_id=" + CLIENT_ID);
// }


const CLIENT_ID = "";
const REDIRECT_URI = "http://localhost:8080/dummy"; // Specify your redirect URI

function loginWithGithub() {
  const redirectUrl = encodeURIComponent(REDIRECT_URI);
  window.location.assign(
    `https://github.com/login/oauth/authorize?client_id=${CLIENT_ID}&redirect_uri=${redirectUrl}`
  );
}
// function loginWithGithub() {
//   fetch("http://localhost:8080/login")
//     .then((response) => {
//       if (!response.ok) {
//         throw new Error("Failed to fetch access token");
//       }
//       return response.json();
//     })
//     .then((data) => {
//       if (!data || !data.accessToken) {
//         throw new Error("Access token not found in response");
//       }
//       localStorage.setItem("accessToken", data.accessToken);
//       window.location.assign("http://localhost:8080"); // Redirect to backend after authentication
//     })
//     .catch((error) => console.error("Error logging in:", error.message));
// }

function Presentation() {
  return (
    <>
      <MKBox
        minHeight="75vh"
        width="100%"
        sx={{
          backgroundImage: `url(${bgImage})`,
          backgroundSize: "cover",
          backgroundPosition: "top",
          display: "grid",
          placeItems: "center",
        }}
      >
        <Container>
          <Grid container item xs={12} lg={7} justifyContent="center" mx="auto">
            <MKTypography
              variant="h1"
              color="white"
              mt={-6}
              mb={1}
              sx={({ breakpoints, typography: { size } }) => ({
                [breakpoints.down("md")]: {
                  fontSize: size["3xl"],
                },
              })}
            >
              NITCONF{" "}
            </MKTypography>
            <MKTypography
              variant="body1"
              color="white"
              textAlign="center"
              px={{ xs: 6, lg: 12 }}
              mt={1}
            >
              Explore insightful reviews penned by world-renowned authors across various domains.
              Delve into the depths of their expertise as they dissect complex topics, unravel
              profound insights, and offer nuanced perspectives.
            </MKTypography>
            <button
              onClick={loginWithGithub}
              style={{
                background: "#008000",
                borderRadius: "8px",
                borderStyle: "none",
                boxSizing: "border-box",
                color: "#FFFFFF",
                cursor: "pointer",
                flexShrink: 0,
                fontFamily:
                  "'Inter UI','SF Pro Display',-apple-system,BlinkMacSystemFont,'Segoe UI',Roboto,Oxygen,Ubuntu,Cantarell,'Open Sans','Helvetica Neue',sans-serif",
                fontSize: "16px",
                fontWeight: "500",
                height: "4rem",
                padding: "0 1.6rem",
                textAlign: "center",
                textShadow: "rgba(0, 0, 0, 0.25) 0 3px 8px",
                transition: "all .5s",
                userSelect: "none",
                WebkitUserSelect: "none",
                touchAction: "manipulation",
              }}
            >
              Github Authentication
            </button>
          </Grid>
        </Container>
      </MKBox>
      <Card
        sx={{
          p: 2,
          mx: { xs: 2, lg: 3 },
          mt: -8,
          mb: 4,
          backgroundColor: ({ palette: { white }, functions: { rgba } }) => rgba(white.main, 0.8),
          backdropFilter: "saturate(200%) blur(30px)",
          boxShadow: ({ boxShadows: { xxl } }) => xxl,
        }}
      >
        <Information />
        <Testimonials />
      </Card>
    </>
  );
}

export default Presentation;
