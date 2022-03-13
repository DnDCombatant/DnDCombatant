<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>DnDCombatant</title>
    <style>
      .characterName.ng-valid {
          background-color: lightgreen;
      }
      .characterName.ng-dirty.ng-invalid-required {
          background-color: red;
      }
      .characterName.ng-dirty.ng-invalid-minlength {
          background-color: yellow;
      }

      .email.ng-valid {
          background-color: lightgreen;
      }
      .email.ng-dirty.ng-invalid-required {
          background-color: red;
      }
      .email.ng-dirty.ng-invalid-email {
          background-color: yellow;
      }
      .width-200 {
      width: 200%;
      }
      .width-50 {
        width: 50%;
      }
      .left-align-25 {
      padding-left: 16.7%;
      }
      .center {
        text-align: center;
      }
      ul {
        list-style-type: none;
        margin: 0;
        padding: 0;
        overflow: hidden;
        background-color: #333;
      }
      li {
        float: left;
      }
      li a {
        display: block;
        color: white;
        text-align: center;
        padding: 14px 16px;
        text-decoration: none;
      }
      li a:hover {
        background-color: #111;
      }
      .active {
        background-color: #04AA6D;
      }
    </style>
     <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  </head>
  <body ng-app="myApp" class="ng-cloak">
    <ul>
      <li><a href="/DnDCombatant/">Home</a></li>
      <li><a class="active" href="/DnDCombatant/CharacterSheet/">Character Sheets</a></li>
      <li><a href="/DnDCombatant/CombatAssist/">Combat Assist</a></li>
    </ul>

      <div class="generic-container" ng-controller="CharacterController as ctrl">
          <div class="panel panel-default">
              <div class="panel-heading center"><span class="lead">${username}'s New Character</span></div>
              <div class="formcontainer center">
                  <form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
                    <input type="hidden" ng-model="ctrl.character.id" />
                    <div class="row">
                      <div class="form-group col-md-12">
                          <label class="col-md-2 control-label" for="cname">Name</label>
                          <div class="col-md-4">
                              <input type="text" ng-model="ctrl.character.characterName" id="cname" class="characterName form-control input-sm" placeholder="Enter Character Name" required ng-minlength="3"/>
                              <div class="has-error" ng-show="myForm.$dirty">
                                  <span ng-show="myForm.cname.$error.required">This is a required field</span>
                                  <span ng-show="myForm.cname.$error.minlength">Minimum length required is 3</span>
                                  <span ng-show="myForm.cname.$invalid">This field is invalid </span>
                              </div>
                          </div>
                      </div>
                    </div>


                    <div class="row">
                      <div class="form-group col-md-12">
                          <label class="col-md-2 control-label" for="level">Level</label>
                          <div class="col-md-4">
                              <input type="text" ng-model="ctrl.character.level" id="level" class="form-control input-sm" placeholder="Enter Character Level." required/>
                              <div class="has-error" ng-show="myForm.$dirty">
                                <span ng-show="myForm.cname.$error.required">This is a required field</span>
                              </div>
                          </div>
                      </div>
                    </div>

                    <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-2 control-label" for="health">Health</label>
                        <div class="col-md-4">
                            <input type="text" ng-model="ctrl.character.health" id="health" class="form-control input-sm" placeholder="Enter Character Health." required/>
                            <div class="has-error" ng-show="myForm.$dirty">
                                <span ng-show="myForm.cname.$error.required">This is a required field</span>
                            </div>
                        </div>
                    </div>
                    </div>

                    <div class="col width-200 left-align-25">
                        <div class="form-group">
                            <div class="row col-md-3">
                                <div class="col-md-2 floatRight" style="width: 90px;">
                                        <label class="control-label" for="strength">STR</label><br>
                                        <input type="number" ng-model="ctrl.character.strength" id="strength" class="form-control input-sm" placeholder="#" required/>
                                </div>
                                <div class="col-md-2 floatRight" style="width: 90px;">
                                        <label class="control-label" for="dexterity">DEX</label><br>
                                        <input type="number" ng-model="ctrl.character.dexterity" id="dexterity" class="form-control input-sm" placeholder="#" required/>
                                </div>
                                <div class="col-md-2 floatRight" style="width: 90px;">
                                        <label class="control-label" for="constitution">CON</label><br>
                                        <input type="number" ng-model="ctrl.character.constitution" id="constitution" class="form-control input-sm" placeholder="#" required/>
                                </div>
                                <div class="col-md-4 floatRight" style="width: 90px;">
                                        <label class="control-label" for="intelligence">INT</label><br>
                                        <input type="number" ng-model="ctrl.character.intelligence" id="intelligence" class="form-control input-sm" placeholder="#" required/>
                                </div>
                                <div class="col-md-3 floatRight" style="width: 90px;">
                                        <label class="control-label" for="wisdom">WIS</label><br>
                                        <input type="number" ng-model="ctrl.character.wisdom" id="wisdom" class="form-control input-sm" placeholder="#" required/>
                                </div>
                                <div class="col-md-2 floatRight" style="width: 90px;">
                                        <label class="control-label" for="charisma">CHA</label><br>
                                        <input type="number" ng-model="ctrl.character.charisma" id="charisma" class="form-control input-sm" placeholder="#" required/>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                      <div class="form-group col-md-12">
                          <label class="col-md-2 control-label" for="speed">Speed</label>
                          <div class="col-md-4">
                              <input type="number" ng-model="ctrl.character.speed" id="speed" class="form-control input-sm" placeholder="Enter Character Speed." required/>
                          </div>
                      </div>
                    </div>

                    <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-2 control-label" for="characterClass">Class</label>
                        <div class="col-md-4">
                            <input type="text" ng-model="ctrl.character.characterClass" id="characterClass" class="form-control input-sm" placeholder="Enter Character Class."/>
                        </div>
                    </div>
                    </div>

                    <div class="row">
                      <div class="form-group col-md-12">
                          <label class="col-md-2 control-label" for="background">Background</label>
                          <div class="col-md-4">
                              <select ng-model="ctrl.character.background" id="background" class="form-control input-sm" placeholder="Character Background."/>
                                <option></option>
                                <option>Folk Hero</option>
                                <option>Hermit</option>
                                <option>Nomad</option>
                                <option>Sage</option>
                                <option>Soldier</option>
                          </div>
                      </div>
                    </div>

                      <div class="row">
                          <div class="form-actions floatRight">
                              <input type="submit"  value="{{!ctrl.character.id ? 'Add' : 'Update'}}" class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid">
                              <button type="button" ng-click="ctrl.reset()" class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Reset Form</button>
                          </div>
                      </div>
                  </form>
              </div>
          </div>
          <div class="panel panel-default">
                <!-- Default panel contents -->
              <div class="panel-heading center"><span class="lead">List of Characters </span></div>
              <div class="tablecontainer">
                  <table class="table table-hover">
                      <thead>
                          <tr>
                              <th>ID.</th>
                              <th>Name</th>
                              <th>Lvl</th>
                              <th>HP</th>
                              <th>STR</th>
                              <th>DEX</th>
                              <th>CON</th>
                              <th>INT</th>
                              <th>WIS</th>
                              <th>CHA</th>
                              <th>Spd</th>
                              <th>Class</th>
                              <th>Background</th>
                              <th width="20%"></th>
                          </tr>
                      </thead>
                      <tbody>
                          <tr ng-repeat="c in ctrl.characters">
                              <td><span ng-bind="c.id"></span></td>
                              <td><span ng-bind="c.characterName"></span></td>
                              <td><span ng-bind="c.level"></span></td>
                              <td><span ng-bind="c.health"></span></td>
                              <td><span ng-bind="c.strength"></span></td>
                              <td><span ng-bind="c.dexterity"></span></td>
                              <td><span ng-bind="c.constitution"></span></td>
                              <td><span ng-bind="c.intelligence"></span></td>
                              <td><span ng-bind="c.wisdom"></span></td>
                              <td><span ng-bind="c.charisma"></span></td>
                              <td><span ng-bind="c.speed"></span>ft</td>
                              <td><span ng-bind="c.characterClass"></span></td>
                              <td><span ng-bind="c.background"></span></td>
                              <td>
                              <button type="button" ng-click="ctrl.edit(c.id)" class="btn btn-success custom-width">Edit</button>  <button type="button" ng-click="ctrl.remove(c.id)" class="btn btn-danger custom-width">Remove</button>
                              </td>
                          </tr>
                      </tbody>
                  </table>
              </div>
          </div>
      </div>

      <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
      <script src="<c:url value='/static/js/app.js' />"></script>
      <script src="<c:url value='/static/js/service/character_service.js' />"></script>
      <script src="<c:url value='/static/js/controller/character_controller.js' />"></script>
  </body>
</html>