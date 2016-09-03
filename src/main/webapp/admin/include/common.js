function showMsg(message) {
	Messenger.options = {
		'extraClasses': 'messenger-fixed messenger-on-top messenger-on-right',
		'theme': "flat"
	};
	Messenger().post({
		'message': message,
		'showCloseButton': true
	});
}

function showErrMsg(data) {
	showMsg('(code:' + data.code + ')' + data.errorMessage);
}

function showNetworkErrMsg(data, status) {
	showMsg('(status:' + status + ')' + data);
}

function isErr(data) {
	return data.code != 0;
}

function logout($window) {
	jQuery.post("api/logout", function(data) {
		$window.location.href = "login.jsp";
	});
}

function updatePager($scope) {
	var maxPageLabelCount = 5;
	var arr = new Array();
	var pagerResp = $scope.pagerResp;
	var begin = parseInt((pagerResp.currentPage - 1) / maxPageLabelCount) * maxPageLabelCount;
	var end = pagerResp.pageCount < begin + maxPageLabelCount ? pagerResp.pageCount : begin + maxPageLabelCount;
	for (var i = begin; i < end; i++) {
		arr.push({
			"pageIndex": i,
			"pageLabel": String(i + 1)
		});
	}
	$scope.pager.pages = arr;
	$scope.pager.pageup.isDisabled = !pagerResp.hasPrevious;
	$scope.pager.pagedown.isDisabled = !pagerResp.hasNext;
	$scope.pager.activePageIndex = pagerResp.currentPage - 1;
}

function toPage(pageIndex, $scope) {
	if (pageIndex == $scope.pager.activePageIndex) {
		return;
	}
	$scope.reload(pageIndex);
}

function pageup($scope) {
	if ($scope.pager.pageup.isDisabled) {
		return;
	}
	$scope.reload($scope.pager.activePageIndex - 1);
}

function pagedown($scope) {
	if ($scope.pager.pagedown.isDisabled) {
		return;
	}
	$scope.reload($scope.pager.activePageIndex + 1);
}
