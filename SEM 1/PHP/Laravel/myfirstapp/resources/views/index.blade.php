<?php
?>

<!doctype html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>

<body>

    <div class="container">
        <div class="card">
            <div class="card-header">
                <div class="row">
                    <div class="col col-md-6"><b>Student Data</b></div>
                    <div class="col col-md-6">
                        <a href="{{ route('students.create') }}" class="btn btn-success btn-sm float-end">Add</a>
                    </div>
                </div>
            </div>
            <div class="card-body">
                <table class="table table-bordered">
                    <tr>
                        <th>Image</th>
                        <th>Name</th>
                        <th>Email</th>
                        <th>Gender</th>
                        <th>Action</th>
                    </tr>
                    @if(count($data) > 0)

                    @foreach($data as $row)

                    <tr>
                        <td><img src="{{ asset('images/' . $row->student_image) }}" width="75" /></td>
                        <td>{{ $row->student_name }}</td>
                        <td>{{ $row->student_email }}</td>
                        <td>{{ $row->student_gender }}</td>
                        <td>
                            <form method="post" action="{{ route('students.destroy', $row->id) }}">
                                @csrf
                                @method('DELETE')
                                <a href="{{ route('students.show', $row->id) }}" class="btn btn-primary btn-sm">View</a>
                                <a href="{{ route('students.edit', $row->id) }}" class="btn btn-warning btn-sm">Edit</a>
                                <input type="submit" class="btn btn-danger btn-sm" value="Delete" />
                            </form>

                        </td>
                    </tr>

                    @endforeach

                    @else
                    <tr>
                        <td colspan="5" class="text-center">No Data Found</td>
                    </tr>
                    @endif
                </table>
            </div>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</body>

</html>