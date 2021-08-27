using Microsoft.VisualStudio.TestTools.UnitTesting;
using OpenQA.Selenium.Chrome;

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

        [TestCleanup]
        public void CleanUP()
        {

        }
    }
}
