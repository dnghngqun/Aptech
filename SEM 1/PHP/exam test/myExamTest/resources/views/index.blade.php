@extends('master')

@section('content')
<h1>Product List</h1>

<table class="table table-bordered">
    <thead>
        <tr>
            <th scope="col">ProductType</th>
            <th scope="col">Quantity</th>
            <th scope="col">Note</th>
            <th scope="col">Action</th>
        </tr>
    </thead>
    <tbody>

        @if(count($data) > 0)
        @foreach($data as $row)

        <tr>
            <td>{{ $row->ProductType }}</td>
            <td>${{ $row->Quantity }}</td>
            <td>{{ $row->Note }}</td>
            <td>
                <form method="post" action="{{ route('product.destroy', $row->id) }}">
                    @csrf
                    @method('DELETE')
                    <a href="{{ route('product.show', $row->id) }}" class="btn btn-primary btn-sm">View</a>
                    <a href="{{ route('product.edit', $row->id) }}" class="btn btn-warning btn-sm">Edit</a>
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

    </tbody>
</table>

<a class="btn btn-primary" href="{{ route('product.create')}}" role="button">Create Product</a>

@endsection