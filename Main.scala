import com.cibo.evilplot.plot._
import com.cibo.evilplot.plot.aesthetics.DefaultTheme._

import java.time.LocalDate
import java.time.format.DateTimeFormatter

import com.github.tototoshi.csv._
import java.io.File

import play.api.libs.json._

object Main extends App{
  val reader = CSVReader.open(new File("C:\\Users\\SALA A\\Downloads/movie_dataset.csv"))
  val data = reader.allWithHeaders()
  reader.close()

  val dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
  val releaseDateList = data
    .map(row => row("release_date"))
    .filter(!_.equals(""))
    .map(text => LocalDate.parse(text, dateFormatter))

  val yearReleaseList = releaseDateList
    .map(_.getYear).map(_.toDouble)
  Histogram(yearReleaseList)
    .title("Años de lanzamiento")
    .xAxis()
    .yAxis()
    .xbounds(1926.0, 2018.0)
    .render()
    .write(new File("C:\\Users\\SALA A\\Downloads\\Representación.png"))

    val productionCompanies = data
      .flatMap(row => row.get("Production_companies"))
      .map(row => Json.parse(row))
      .flatMap(jsonData => jsonData \\ "name")
      .map(jsValue => jsValue.as[String])
      .groupBy(identity)
      .map{ case (keyword, lista) => (keyword, lista.size)}
      .toList
      .sortBy(_._2)
      .reverse

    val pCompaniesValues = productionCompanies.take(10).map(_._2).map(_.toDouble)
    val pCompaniesLables = productionCompanies.take(10).map(_._1)

    BarChart(pCompaniesValues)
      .title("Compañias Productoras")
      .xAxis(pCompaniesLables)
      .yAxis()
      .frame()
      .yLabel("Productions")
      .bottomLegend()
      .render()
      .write(new File("C:\\Users\\SALA A\\Downloads\\Representación2.png"))

    implicit val theme = DefaultTheme.copy(
      elements = DefaultElements.copy(categoricalXAxisLabelOrientation = 45)
    )
}
