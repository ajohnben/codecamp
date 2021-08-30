using Microsoft.VisualStudio.TestTools.UnitTesting;
using OpenQA.Selenium.Chrome;
using System;

namespace CodeCampTest
{
    [TestClass]
    public class CodeCampTest
    {
        private ChromeDriver driver;

        [TestInitialize]
        public void Setup()
        {
            driver = new ChromeDriver();
            driver.Manage().Window.Maximize();
        }

        [TestMethod]
        public void EarthRadiusTest()
        {
            
            driver.Url = "https://d21vtxezke9qd9.cloudfront.net/#/planets";

            double radius = new PlanetsPage(driver).GetPlanetByName("Earth").GetRadius();

            Assert.AreEqual(6371, radius);
        }

        [TestMethod]
        public void FillLoginFormThenSubmitTest()
        {
            driver.Url = "https://d21vtxezke9qd9.cloudfront.net/#/planets";

            new PlanetsPage(driver).FillInLoginModalFormThenSubmit();

        }

        [TestMethod]
        public void LoginModalErrorMessageTest()
        {
            driver.Url = "https://d21vtxezke9qd9.cloudfront.net/#/planets";
            var messages = new PlanetsPage(driver).GetLoginModalError();

            Console.WriteLine(messages);
        }

        [TestMethod]
        public void ExploreDialogMessageConfirmTextTest()
        {
            driver.Url = "https://d21vtxezke9qd9.cloudfront.net/#";
            Console.WriteLine(new PlanetsPage(driver).ClickJupiterExploreButtonThenGetString());


        }



        [TestCleanup]
        public void CleanUP()
        {

        }
    }
}
